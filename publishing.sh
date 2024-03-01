if [[ -z "$IMAGE_VERSION" ]]; then
    IMAGE_VERSION=latest
fi
docker push 671140455224.dkr.ecr.eu-central-1.amazonaws.com/gdc/gdc-apicore:$IMAGE_VERSION