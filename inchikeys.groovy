@Grab(group='org.openscience.cdk', module='cdk-bundle', version='2.5')

import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.INCHI_RET;

def cli = new CliBuilder(usage: 'inchis.groovy')
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

factory = InChIGeneratorFactory.getInstance();

while (iterator.hasNext()) {
  IAtomContainer mol = iterator.next()
  cmpName = mol.title
  generator = factory.getInChIGenerator(mol);
  inchi = ""
  if (generator.getReturnStatus() == INCHI_RET.OKAY ||
      generator.getReturnStatus() == INCHI_RET.WARNING) {
    key = generator.getInchiKey()
    println "$cmpName\t$key"
  }
}
