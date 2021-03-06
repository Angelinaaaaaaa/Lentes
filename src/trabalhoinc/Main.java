/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoinc;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author julia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        DataSource dados = new DataSource("src/trabalhoinc/Lentes.arff");
        Instances instancia = dados.getDataSet();
        System.out.println(instancia.toString());

        instancia.setClassIndex(4);

        J48 classificador = new J48();
        classificador.buildClassifier(instancia);

        Instance dadosPessoa = new DenseInstance(5);
        dadosPessoa.setDataset(instancia);

        while (true) {
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira sua idade: "));
            if (idade < 0 || idade > 200) {
                JOptionPane.showMessageDialog(null, "Idade incorreta!");
            } else {
                if (idade <= 27) {
                    dadosPessoa.setValue(0, "Jovem");
                    break;
                } else {
                    if (idade <= 38) {
                        dadosPessoa.setValue(0, "Pre_prebiotico");
                        break;
                    } else {
                        dadosPessoa.setValue(0, "Prebiotico");
                        break;
                    }
                }
            }
        }

        while (true) {
            int prescricao = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 se possui hipermetropia ou digite 1 se possui miopia."));
            if (prescricao < 0 || prescricao > 1) {
                JOptionPane.showMessageDialog(null, "Prescri????o incorreta!");
            } else {
                if (prescricao == 1) {
                    dadosPessoa.setValue(1, "Miopia");
                    break;
                } else {
                    dadosPessoa.setValue(1, "Hipermetropia");
                    break;
                }
            }
        }

        while (true) {
            int astigmatico = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 se ?? astigm??tico ou digite 1 se n??o ??."));
            if (astigmatico < 0 || astigmatico > 1) {
                JOptionPane.showMessageDialog(null, "Inser????o incorreta!");
            } else {
                if (astigmatico == 1) {
                    dadosPessoa.setValue(2, "Nao");
                    break;
                } else {
                    dadosPessoa.setValue(2, "Sim");
                    break;
                }
            }
        }

        while (true) {
            int taxa = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 se a taxa de produ????o de l??grimas ?? reduzida ou digite 1 se ?? normal."));
            if (taxa < 0 || taxa > 1) {
                JOptionPane.showMessageDialog(null, "Inser????o incorreta!");
            } else {
                if (taxa == 1) {
                    dadosPessoa.setValue(3, "Normal");
                    break;
                } else {
                    dadosPessoa.setValue(3, "Reduzida");
                    break;
                }
            }
        }

        double probabilidade[] = classificador.distributionForInstance(dadosPessoa);

        if (probabilidade[0] > probabilidade[1] && probabilidade[0] > probabilidade[2]) {
            JOptionPane.showMessageDialog(null, "O paciente n??o dever?? usar lentes de contato!");
        } else {
            if (probabilidade[1] > probabilidade[0] && probabilidade[1] > probabilidade[2]) {
                JOptionPane.showMessageDialog(null, "O paciente dever?? usar lentes de contato leves!");
            } else {
                JOptionPane.showMessageDialog(null, "O paciente dever?? usar lentes de contato fortes!");
            }
        }
    }
}
