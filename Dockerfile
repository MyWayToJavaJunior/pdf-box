FROM java:8-jre
LABEL authors="Bovin Aleksandr <bovin.a@outlook.com>, Bobrov Nickolay <werasdas@gmail.com>"

ENV DISPLAY=:99.0

RUN    apt-get update \
    && apt-get install curl -y \
    && curl -sL https://deb.nodesource.com/setup_6.x -o nodesource_setup.sh \
    && bash ./nodesource_setup.sh \
    && apt-get install -y \
                nodejs \
                build-essential \
                xvfb \
                x11-xkb-utils \
                xfonts-100dpi \
                xfonts-75dpi \
                xfonts-scalable \
                xfonts-cyrillic \
                x11-apps \
                clang \
                libdbus-1-dev \
                libgtk2.0-dev \
                libnotify-dev \
                libgnome-keyring-dev \
                libgconf2-dev \
                libasound2-dev \
                libcap-dev \
                libcups2-dev \
                libxtst-dev \
                libxss1 \
                libnss3-dev \
                gcc-multilib \
                g++-multilib \
    && npm install electron-pdf -g \
    && mkdir /server \
    && rm -r /var/cache/apt/*

COPY target/pdf-tool.jar /server/
COPY entrypoint.sh /server/

EXPOSE 8080

WORKDIR /server
ENTRYPOINT ["/server/entrypoint.sh"]