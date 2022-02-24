# Deterministic creation of uuid from gtin14

Quick simple examples of uuid generation for a [uuid type 5](https://en.wikipedia.org/wiki/Universally_unique_identifier#Versions_3_and_5_(namespace_name-based)) which uses a namespace UUID to create a SHA1 hash of the value.
Because the python library *requires* using an enum of namespaces, the other examples use the UUID value of the pythong DNS Namespace.

The list of gtins, one per line is in `/inputs` and generated files are in `/outputs/[java|js|python}_uuids.ts]`

To run the POCs you'll need to replace the absolute paths from my machine (because I'm lazy).
