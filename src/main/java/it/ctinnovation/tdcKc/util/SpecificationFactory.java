package it.ctinnovation.tdcKc.util;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.filter.Filter;
import ch.ralscha.extdirectspring.filter.NumericFilter;
import ch.ralscha.extdirectspring.filter.StringFilter;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import org.springframework.data.jpa.domain.Specification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

public class SpecificationFactory {

    public static <T> Specification<T> buildSpecs(ExtDirectStoreReadRequest storeRequest, Class<T> type) {
        if (storeRequest.getFilters().isEmpty()) {
            return null;
        }
        List<Filter> filters = storeRequest.getFilters().stream().collect(Collectors.toList());
        Specification<T> specification = where(createSingleSpec(filters.remove(0), type));
        for (Filter input : filters) {
            specification = specification.and(createSingleSpec(input, type));
        }
        return specification;

    }

    public static <T> Specification<T> createSingleSpec(Filter filter, Class<T> type) {
        if (filter instanceof StringFilter) {
            StringFilter stringFilter = (StringFilter) filter;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ITALY);
                formatter.parse(stringFilter.getValue());
                return dateSpecification(stringFilter);
            } catch (ParseException e) {
                return stringSpecification(stringFilter);
            }
        }
        if (filter instanceof NumericFilter) {
            return numericSpecification((NumericFilter) filter);
        }
        return null;
    }

    public static <T> Specification<T> dateSpecification(StringFilter filter) {
        OffsetDateTime date = OffsetDateTime.parse(filter.getValue());
        ZonedDateTime zdt = date.atZoneSameInstant(ZoneId.of("Europe/Rome"));
        LocalDateTime ldt = zdt.toLocalDateTime();
        switch (filter.getRawComparison()) {
            case "==":
                return dateEqual(filter.getField(), ldt);
            case "!=":
                return dateNotEqual(filter.getField(), ldt);
            case ">":
                return dateGreater(filter.getField(), ldt);
            case ">=":
                return dateGreaterEqual(filter.getField(), ldt);
            case "<":
                return dateLower(filter.getField(), ldt);
            case "<=":
                return dateLowerEqual(filter.getField(), ldt);
            default:
                return null;
        }
    }

    private static <T> Specification<T> dateEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.equal(root.get(field), value);
    }

    private static <T> Specification<T> dateNotEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.notEqual(root.get(field), value);
    }

    private static <T> Specification<T> dateGreater(String field, LocalDateTime value) {
        return  (root, query, cb) -> cb.greaterThan(root.get(field), value);
    }

    private static <T> Specification<T> dateGreaterEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(field), value);
    }

    private static <T> Specification<T> dateLower(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.lessThan(root.get(field), value);
    }

    private static <T> Specification<T> dateLowerEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(field), value);
    }

    private static <T> Specification<T> numericSpecification(NumericFilter filter) {
        switch (filter.getRawComparison()) {
            case "==":
                return numericEqual(filter.getField(), filter.getValue());
            case "!=":
                return numericNotEqual(filter.getField(), filter.getValue());
            case ">":
                return numericGreater(filter.getField(), filter.getValue());
            case ">=":
                return numericGreaterEqual(filter.getField(), filter.getValue());
            case "<":
                return numericLower(filter.getField(), filter.getValue());
            case "<=":
                return numericLowerEqual(filter.getField(), filter.getValue());
            default:
                return null;
        }
    }

    private static <T> Specification<T> numericEqual(String field, Number value) {
        return (root, query, cb) -> cb.equal(root.get(field), value);
    }

    private static <T> Specification<T> numericNotEqual(String field, Number value) {
        return (root, query, cb) -> cb.notEqual(root.get(field), value);
    }

    private static <T> Specification<T> numericGreater(String field, Number value) {
        return (root, query, cb) -> cb.gt(root.get(field), value);
    }

    private static<T> Specification<T> numericGreaterEqual(String field, Number value) {
        return (root, query, cb) -> cb.ge(root.get(field), value);
    }

    private static <T> Specification<T> numericLower(String field, Number value) {
        return (root, query, cb) -> cb.lt(root.get(field), value);
    }

    private static <T> Specification<T> numericLowerEqual(String field, Number value) {
        return (root, query, cb) -> cb.le(root.get(field), value);
    }

    private static <T> Specification<T> stringSpecification(StringFilter filter) {
        switch (filter.getRawComparison()) {
            case "like":
                return stringLike(filter.getField(), filter.getValue());
            case "==":
                return stringEqual(filter.getField(), filter.getValue());
            case "!=":
                return stringNotEqual(filter.getField(), filter.getValue());
            case "nempty":
                return stringNotEmpty(filter.getField());
            case "empty":
                return stringEmpty(filter.getField());
            default:
                return null;
        }
    }

    private static <T> Specification<T> stringEmpty(String attribute) {
        return (root, query, cb) -> cb.isNull(root.get(attribute));
    }

    private static <T> Specification<T> stringNotEmpty(String attribute) {
        return (root, query, cb) -> cb.isNotNull(root.get(attribute));
    }

    private static <T> Specification<T> stringNotEqual(String attribute, String value) {
        return (root, query, cb) -> cb.notEqual(root.get(attribute), value);
    }

    private static <T> Specification<T> stringLike(String attribute, String value) {
        return (root, query, cb) -> cb.like(root.get(attribute), "%" + value + "%");
    }

    private static <T> Specification<T> stringEqual(String attribute, String value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }

}
