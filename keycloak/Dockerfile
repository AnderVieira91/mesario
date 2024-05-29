FROM quay.io/keycloak/keycloak:22.0.1 as builder

WORKDIR /opt/keycloak

RUN /opt/keycloak/bin/kc.sh build
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]

