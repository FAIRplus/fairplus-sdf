@Grab(group='org.openscience.cdk', module='cdk-bundle', version='2.3')

import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.INCHI_RET;

iterator = new IteratingSDFReader(
  new File("etoxsys-all-sdf.sdf").newReader(),
  SilentChemObjectBuilder.getInstance()
)

factory = InChIGeneratorFactory.getInstance();

while (iterator.hasNext()) {
  IAtomContainer mol = iterator.next()
  cmpName = mol.title
  generator = factory.getInChIGenerator(mol);
  inchi = ""
  if (generator.returnStatus != INCHI_RET.OKAY) {
    println "$cmpName\t" + generator.message + "\t" + generator.returnStatus
  }
}
