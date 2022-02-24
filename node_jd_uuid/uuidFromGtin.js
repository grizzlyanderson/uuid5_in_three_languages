const uuid = require('uuid');
const fs = require('fs');
const PYTHON_DNS_NAMESPACE_UUID = '6ba7b810-9dad-11d1-80b4-00c04fd430c8'

fs.readFile('/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/inputs/gtins.txt',
    (err, data) => {
    let writer = fs.createWriteStream('/Users/eric.anderson/projects/github.com/ibotta/compare_uuid_gen/outputs/js_uuids.txt')
    let gtins = data.toString().split("\n")
    gtins.forEach((gtin, i) => {
        let generatedUuid = uuid.v5(gtin, PYTHON_DNS_NAMESPACE_UUID)
        writer.write(gtin + "; " + generatedUuid + "\n");
    });
    writer.close();
});
