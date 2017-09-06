from flask import Flask


def create_app():
    flask_app = Flask(__name__)
    flask_app.debug = True
    return flask_app


app = create_app()
