# FAIRPlus SDF tools

## Requirements

To run the below scripts, you need a [Groovy](https://groovy.apache.org/download.html) installation.
The Groovy scripts use version 2.3 of the [Chemistry Development Kit](https://cdk.github.io/)
(see also doi:[10.1186/s13321-017-0220-4](https://doi.org/10.1186/s13321-017-0220-4)).
This library and its use in Groovy is further explain in
the book [Groovy Cheminformatics with the Chemistry Development Kit](https://egonw.github.io/cdkbook/).

## Record validation

When generating InChIs, the InChI library may return two success states reflecting issues with
the compound record in the SD file: WARNING and ERROR. This first script reports such issues:

```bash
groovy badRecords.groovy
```

## Calculate InChIs

The second script calculates InChIs for entries in the SD file, but only when the InChI generation
was OKAY or with a WARNING (two InChI library success states):

```bash
groovy inchis.groovy
```

When the success state is ERROR, nothing is outputted.
