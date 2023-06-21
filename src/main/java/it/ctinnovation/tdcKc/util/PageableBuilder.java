package it.ctinnovation.tdcKc.util;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.SortInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PageableBuilder {
    public static Pageable of(ExtDirectStoreReadRequest storeRequest, @NotNull SortInfo defaultSort) {
        if (storeRequest.getSorters() != null) {
            List<SortInfo> sorters=storeRequest.getSorters().stream().collect(Collectors.toList());
            storeRequest.getSorters().stream()
                .filter(sortInfo -> sortInfo.getProperty().equals(defaultSort.getProperty()))
                .findFirst()
                    .orElseGet(()->{
                        sorters.add(defaultSort);
                        return defaultSort;
                    });
            Sort springSort = SortAdapter.createSort(sorters);
            return PageRequest.of(storeRequest.getPage() - 1, storeRequest.getLimit(), springSort);
        }
        else{
            List<SortInfo> sorters=new ArrayList<>();
            sorters.add(defaultSort);
            Sort springSort = SortAdapter.createSort(sorters);
            return PageRequest.of(storeRequest.getPage() - 1, storeRequest.getLimit(), springSort);
        }

    }

    public static Pageable of(ExtDirectStoreReadRequest storeRequest) {
        if (storeRequest.getSorters() != null) {
            Sort springSort = SortAdapter.createSort(storeRequest.getSorters());
            return PageRequest.of(storeRequest.getPage() - 1, storeRequest.getLimit(), springSort);
        }
        else{
                return PageRequest.of(storeRequest.getPage() - 1, storeRequest.getLimit());
            }
        }
}
