FROM python:3.6.2-slim

RUN mkdir -p /app

ADD . /app

WORKDIR /app

RUN pip install -r requirements.txt

EXPOSE 5000 5001

CMD ['/usr/local/bin/python', 'app.py']
