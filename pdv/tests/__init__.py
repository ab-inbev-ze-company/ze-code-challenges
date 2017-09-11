from unittest import TestCase
from pdv.models import (
    create_engine,
    scoped_session,
    sessionmaker,
    Address,
    Base,
    CoverageArea,
    Pdv,
)
from pdv.views import app


engine = create_engine('sqlite://', convert_unicode=True)


class BaseTestCase(TestCase):

    def init_db(self):
        self.db_session = scoped_session(sessionmaker(autocommit=False,
                                                      autoflush=False,
                                                      bind=engine))
        Base.query = self.db_session.query_property()
        Base.metadata.create_all(engine)

    def drop_db(self):
        Base.query = self.db_session.query_property()
        self.db_session.flush()
        self.db_session.remove()

    def setUp(self):
        app.testing = True
        self.app = app.test_client()
        self.init_db()

    def tearDown(self):
        self.drop_db()
