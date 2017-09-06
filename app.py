import os
from pdv.views import app
from pdv.models import db_session, init_db

if not os.path.exists('database.sqlite3'):
    init_db()


@app.teardown_appcontext
def shutdown_session(exception=None):
    db_session.remove()


if __name__ == '__main__':
    app.run(host='0.0.0.0')
