from sqlalchemy import create_engine

class BadgeType:
    """
    OrderedDict([('ORDER', 99.0), ('KEY', 'Z'), ('CLASS', 'COA'), ('SDATE', datetime.date(2088, 12, 31)), ('EDATE', None), ('AMOUNT', 0.0), ('METACLASS', 'X'), ('BADGEOK', False), ('TIMESTAMP', False), ('ONBADGE', ''), ('NAME', 'Report COAs for nonmembers'), ('FRIDAY', False), ('SATURDAY', False), ('SUNDAY', False), ('THURSDAY', False)])
    OrderedDict([
    ('ORDER', 99.0),
    ('KEY', 'Z'),
    ('CLASS', 'COA'),
    ('SDATE', datetime.date(2088, 12, 31)), ('EDATE', None), ('AMOUNT', 0.0), ('METACLASS', 'X'), ('BADGEOK', False), ('TIMESTAMP', False), ('ONBADGE', ''), ('NAME', 'Report COAs for nonmembers'), ('FRIDAY', False), ('SATURDAY', False), ('SUNDAY', False), ('THURSDAY', False)])
    """


if __name__ == '__main__':
    engine = create_engine('sqlite:///:memory:', echo=True)
