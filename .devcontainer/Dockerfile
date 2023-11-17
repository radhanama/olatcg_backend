FROM mcr.microsoft.com/devcontainers/java:1-17-bullseye

ARG INSTALL_MAVEN="false"
ARG MAVEN_VERSION=""

ARG INSTALL_GRADLE="false"
ARG GRADLE_VERSION=""

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi \
    && if [ "${INSTALL_GRADLE}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""; fi

RUN apt-get update && \
    apt-get install -y wget libgomp1 ncbi-blast+ && \
    wget https://ftp.ncbi.nlm.nih.gov/genomes/refseq/bacteria/Agromyces_intestinalis/all_assembly_versions/GCF_008365295.1_ASM836529v1/GCF_008365295.1_ASM836529v1_rna_from_genomic.fna.gz && \
    gunzip GCF_008365295.1_ASM836529v1_rna_from_genomic.fna.gz && \
    apt-get remove -y wget && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* &&\
    makeblastdb -in GCF_008365295.1_ASM836529v1_rna_from_genomic.fna -dbtype nucl -out /opt/olatcg-backend/blast/dbs/agromyces_database

# [Optional] Uncomment this section to install additional OS packages.
# RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
#     && apt-get -y install --no-install-recommends <your-package-list-here>

# [Optional] Uncomment this line to install global node packages.
# RUN su vscode -c "source /usr/local/share/nvm/nvm.sh && npm install -g <your-package-here>" 2>&1
