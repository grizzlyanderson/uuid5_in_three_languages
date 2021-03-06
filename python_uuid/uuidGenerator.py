import sys
import uuid

with open('/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/inputs/gtins.txt') as gtins:
    uuidOut = open('/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/outputs/python_uuids.txt', 'w')
    gtin = gtins.readline().strip()
    #customUuidNamespace = uuid.uuid5(uuid.NAMESPACE_DNS, 'com.ibotta.product.gtin14')
    while gtin:
        uuid_result = uuid.uuid5(uuid.NAMESPACE_DNS, gtin)
        # cust
        #uuid_result = uuid.uuid5(customUuidNamespace, gtin)
        uuidOut.write(gtin + '; ' + str(uuid_result)+'\n')
        gtin = gtins.readline().strip()
