# syntax=docker/dockerfile:1
FROM docker.io/postgres:16
COPY /database/dvd-rental-customer.sql /docker-entrypoint-initdb.d/

# Install locales package and generate the desired locale
RUN apt-get update && apt-get install -y locales \
    && sed -i '/de_DE.UTF-8/s/^# //g' /etc/locale.gen \
    && locale-gen \
    && update-locale LANG=de_DE.UTF-8

# Set default locale environment variables
ENV LANG de_DE.UTF-8
ENV LANGUAGE de_DE:de
ENV LC_ALL de_DE.UTF-8
