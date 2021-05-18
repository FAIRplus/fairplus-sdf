@Grab(group='org.openscience.cdk', module='cdk-bundle', version='2.5')

import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.tools.manipulator.*;

def cli = new CliBuilder(usage: 'smiles.groovy')
cli.h(longOpt: 'help', 'print this message')
cli.f(longOpt: 'input-file', args:1, argName:'filename', 'Name of the SDF file')
def options = cli.parse(args)

if (options.help) {
  cli.usage()
  System.exit(0)
}

sdfFile = "etoxsys-all-sdf.sdf"
if (options.f) {
  sdfFile = options.f
}

iterator = new IteratingSDFReader(
  new File(sdfFile).newReader(),
  SilentChemObjectBuilder.getInstance()
)

generator = SmilesGenerator.generic()
while (iterator.hasNext()) {
  IAtomContainer mol = iterator.next()
  cmpName = mol.title
  cmpSMILES = generator.createSMILES(mol)
  println "$cmpName\t$cmpSMILES"
}
