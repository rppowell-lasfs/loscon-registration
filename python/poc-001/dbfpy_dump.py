from dbfread import DBF

def dump_dbf(filename):
    dbf = DBF(filename)
    for r in dbf:
        print(r)


if __name__ == '__main__':
    #dump_dbf('./legacy/2017-05-28-regconfi.dbf')
    dump_dbf('./legacy/2017-05-28-classes.dbf')
