# Use the generated image as the base image
FROM openjdk:11-jdk-slim-buster

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

RUN apt-get update && \
    apt-get install -y wget libgomp1 ncbi-blast+ && \
    wget https://ftp.ncbi.nlm.nih.gov/genomes/refseq/bacteria/Agromyces_intestinalis/all_assembly_versions/GCF_008365295.1_ASM836529v1/GCF_008365295.1_ASM836529v1_rna_from_genomic.fna.gz && \
    gunzip GCF_008365295.1_ASM836529v1_rna_from_genomic.fna.gz && \
    apt-get remove -y wget && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* &&\
    makeblastdb -in GCF_008365295.1_ASM836529v1_rna_from_genomic.fna -dbtype nucl -out /opt/olatcg-backend/blast/dbs/agromyces_database

# Copy your application jar and set the working directory
WORKDIR /opt/olatcg-backend
COPY /target/*.jar app.jar

# Use bash as the shell
SHELL ["/bin/bash", "-c"]

# Expose ports and define the command to run your Spring Boot app
EXPOSE 8080
EXPOSE 5005
CMD java ${ADDITIONAL_OPTS} -jar app.jar --spring.profile.active=${PROFILE}
