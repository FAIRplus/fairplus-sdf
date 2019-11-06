# FAIRPlus SDF tools

## Requirements

To run the below scripts, you need a [Groovy](https://groovy.apache.org/download.html) installation.

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
