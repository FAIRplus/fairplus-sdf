# FAIRPlus SDF tools

## Requirements

To run the below scripts, you need a [Groovy](https://groovy.apache.org/download.html) installation.

## Calculate InChIs

The first script calculates InChIs for entries in the SD file, but only when the InChI generation
was OKAY or with a WARNING (two InChI library success states):

```bash
groovy inchis.groovy
```

When the success state is ERROR, nothing is outputted.
