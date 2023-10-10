package Gabriel.brito.dcx.ufpb.br;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ConcessionariaGUI extends JFrame {
    private JList<Veiculo> listaCarros;
    private JComboBox<String> comboBoxBusca;
    private JTextField textFieldValorBusca;
    private DefaultListModel<Veiculo> listModel;
    private ConcessionariaController controller;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConcessionariaGUI concessionariaGUI = new ConcessionariaGUI();
                concessionariaGUI.setVisible(true);
            }
        });
    }

    public ConcessionariaGUI() {
        setTitle("Concessionária");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        controller = new ConcessionariaController();
        listModel = new DefaultListModel<>();
        listaCarros = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaCarros);

        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new FlowLayout());

        String[] opcoesBusca = {"Todos", "Marca", "Ano"};
        comboBoxBusca = new JComboBox<>(opcoesBusca);
        textFieldValorBusca = new JTextField(15);
        JButton buttonBuscar = new JButton("Buscar");
        JButton buttonAdicionar = new JButton("Adicionar Carro");
        JButton buttonRemover = new JButton("Remover Carro");

        buscaPanel.add(comboBoxBusca);
        buscaPanel.add(textFieldValorBusca);
        buscaPanel.add(buttonBuscar);
        buscaPanel.add(buttonAdicionar);
        buscaPanel.add(buttonRemover);

        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String criterioBusca = (String) comboBoxBusca.getSelectedItem();
                String valorBusca = textFieldValorBusca.getText();

                List<Veiculo> resultados = controller.buscarCarros(criterioBusca, valorBusca);
                listModel.clear();

                for (Veiculo veiculo : resultados) {
                    listModel.addElement(veiculo);
                }
            }
        });

        buttonAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
                String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro:"));
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do carro:"));

                Veiculo novoCarro = new Veiculo(marca, modelo, ano, preco);
                controller.adicionarCarro(novoCarro);
                atualizarListaCarros();
            }

        });

        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Veiculo carroSelecionado = listaCarros.getSelectedValue();

                if (carroSelecionado != null) {
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este carro?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        controller.removerCarro(carroSelecionado);
                        atualizarListaCarros();
                    }
                }
            }
        });

        panel.add(buscaPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
        atualizarListaCarros();
    }

    private void atualizarListaCarros() {
        listModel.clear();
        List<Veiculo> carros = controller.getCarros();

        for (Veiculo veiculo : carros) {
            listModel.addElement(veiculo);
        }
    }
    }
