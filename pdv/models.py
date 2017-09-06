import io
import json
import os

from sqlalchemy import create_engine, Column, ForeignKey, Integer, String
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship, sessionmaker, scoped_session


engine = create_engine('sqlite:///database.sqlite3',
                       convert_unicode=True)
db_session = scoped_session(sessionmaker(autocommit=False,
                                         autoflush=False,
                                         bind=engine))


Base = declarative_base()
Base.query = db_session.query_property()


class CoverageArea(Base):
    __tablename__ = 'coverage_area'
    id = Column(Integer, primary_key=True)
    type = Column(String, default='MultiPolygon', nullable=False)
    coordinates = Column(String, nullable=False)
    pdv = relationship("Pdv", back_populates="coverage_area", uselist=False)


class Address(Base):
    __tablename__ = 'address'
    id = Column(Integer, primary_key=True)
    type = Column(String, default="Point", nullable=False)
    coordinates = Column(String, nullable=False)
    pdv = relationship("Pdv", back_populates="address", uselist=False)


class Pdv(Base):
    __tablename__ = 'pdv'
    id = Column(Integer, primary_key=True)
    trading_name = Column(String)
    owner_name = Column(String)
    document = Column(String, unique=True)
    id_coverage_area = Column(Integer, ForeignKey('coverage_area.id'))
    id_address = Column(Integer, ForeignKey('address.id'))
    address = relationship("Address", back_populates="pdv")
    coverage_area = relationship("CoverageArea", back_populates="pdv")


def init_db():
    Base.metadata.create_all(engine)
    json_path = os.path.join(os.path.dirname(__file__), '..', 'pdvs.json')
    with io.open(json_path) as fd:
        content = json.loads(fd.read())
        pdvs = content.get('pdvs', None)
        for pdv in pdvs:

            address = json.loads(pdv.get('address')) \
                .get('coordinates')

            coverage_area = json.loads(pdv.get('coverageArea')) \
                .get('coordinates')

            model_pdv = Pdv()
            model_pdv.id = pdv.get('id')
            model_pdv.trading_name = pdv.get('tradingName')
            model_pdv.owner_name = pdv.get('ownerName')
            model_pdv.document = pdv.get('document')
            model_pdv.coverage_area = CoverageArea()
            model_pdv.coverage_area.coordinates = json.dumps(coverage_area)
            model_pdv.address = Address()
            model_pdv.address.coordinates = json.dumps(address)
            model_pdv.query.session.add(model_pdv)
            model_pdv.query.session.commit()
            model_pdv.query.session.flush()
