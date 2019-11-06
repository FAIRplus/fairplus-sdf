@Grab(group='org.openscience.cdk', module='cdk-bundle', version='2.3')

import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.tools.manipulator.*;

iterator = new IteratingSDFReader(
  new File("etoxsys-all-sdf.sdf").newReader(),
  SilentChemObjectBuilder.getInstance()
)

generator = SmilesGenerator.generic()
while (iterator.hasNext()) {
  IAtomContainer mol = iterator.next()
  cmpName = mol.title
  cmpSMILES = generator.createSMILES(mol)
  println "$cmpName\t$cmpSMILES"
}
