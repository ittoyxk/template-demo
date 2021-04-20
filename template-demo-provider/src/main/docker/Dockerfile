FROM hub.commchina.net/library/openjdk:11.0.9-slim as builder

COPY @project.build.finalName@.jar @project.build.finalName@.jar
RUN jar -xf @project.build.finalName@.jar
RUN mv BOOT-INF/lib/@project.parent.artifactId@-* ./ && mv BOOT-INF/classes/ ./

FROM hub.commchina.net/library/openjdk:11.0.9-slim

COPY gosu/gosu-amd64 /usr/bin/gosu
RUN chmod +x /usr/bin/gosu

COPY entrypoint.sh /application/entrypoint.sh
RUN chmod +x /application/entrypoint.sh

WORKDIR application

COPY --from=builder BOOT-INF/ /application/BOOT-INF
COPY --from=builder META-INF/ /application/META-INF
COPY --from=builder org/ /application/org
COPY --from=builder @project.parent.artifactId@-common-@project.version@.jar /application/BOOT-INF/lib/
COPY --from=builder @project.parent.artifactId@-dao-@project.version@.jar /application/BOOT-INF/lib/
COPY --from=builder @project.parent.artifactId@-biz-@project.version@.jar /application/BOOT-INF/lib/
COPY --from=builder classes/ /application/BOOT-INF/classes

RUN rm /bin/sh && rm /bin/bash

ENTRYPOINT ["/application/entrypoint.sh"]