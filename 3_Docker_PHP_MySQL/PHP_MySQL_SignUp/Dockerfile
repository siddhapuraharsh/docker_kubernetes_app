FROM php:7.2-apache

RUN apt-get update && apt-get install -y

RUN docker-php-ext-install mysqli pdo_mysql

RUN mkdir /app \
 && mkdir /app/php-mysql-demo \
 && mkdir /app/php-mysql-demo/www

COPY www/ /app/php-mysql-demo/www/

RUN cp -r /app/php-mysql-demo/www/* /var/www/html/.
