FROM registry.access.redhat.com/ubi8/ubi-minimal:8.7
WORKDIR /workspace
COPY /target/*-runner /workspace/portifolio-quarkus-api
RUN chmod 775 /workspace/portifolio-quarkus-api
EXPOSE 8080
CMD ["./portifolio-quarkus-api"]
