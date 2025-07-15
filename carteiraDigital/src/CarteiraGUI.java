import br.com.biblioteca.Cartao;
import br.com.biblioteca.CartaoCredito;
import br.com.biblioteca.CartaoDebito;
import br.com.biblioteca.CarteiraDigital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarteiraGUI extends JFrame {
    private CarteiraDigital carteira;
    private DefaultListModel<String> listaModel;

    public CarteiraGUI() {
        super("Carteira Digital");
        carteira = new CarteiraDigital();
        listaModel = new DefaultListModel<>();

        setLayout(new BorderLayout());

        JList<String> listaCartoes = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(listaCartoes);
        add(scrollPane, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel();

        JButton adicionarBtn = new JButton("Adicionar Cartão");
        JButton removerBtn = new JButton("Remover Cartão");
        JButton detalhesBtn = new JButton("Ver Detalhes");

        botoesPanel.add(adicionarBtn);
        botoesPanel.add(removerBtn);
        botoesPanel.add(detalhesBtn);

        add(botoesPanel, BorderLayout.SOUTH);

        adicionarBtn.addActionListener(e -> adicionarCartao());
        removerBtn.addActionListener(e -> {
            int index = listaCartoes.getSelectedIndex();
            if (index >= 0) {
                String info = listaModel.get(index);
                String numero = info.split(" - ")[1];
                carteira.removerCartao(numero);
                listaModel.remove(index);
            }
        });

        detalhesBtn.addActionListener(e -> {
            int index = listaCartoes.getSelectedIndex();
            if (index >= 0) {
                Cartao cartao = carteira.getCartoes().get(index);
                JOptionPane.showMessageDialog(this,
                        "Titular: " + cartao.getTitular() +
                                "\nNúmero: " + cartao.getNumero() +
                                "\nTipo: " + cartao.getTipo() +
                                "\nSaldo/Limite: R$ " + cartao.getSaldo());
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centralizar
        setVisible(true);
    }

    private void adicionarCartao() {
        String[] tipos = {"Crédito", "Débito"};
        String tipo = (String) JOptionPane.showInputDialog(this, "Tipo do cartão:", "Selecionar",
                JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        if (tipo != null) {
            String numero = JOptionPane.showInputDialog("Número do Cartão:");
            String titular = JOptionPane.showInputDialog("Nome do Titular:");

            if (tipo.equals("Crédito")) {
                String limiteStr = JOptionPane.showInputDialog("Limite de crédito:");
                double limite = Double.parseDouble(limiteStr);
                CartaoCredito cc = new CartaoCredito(numero, titular, limite);
                carteira.adicionarCartao(cc);
                listaModel.addElement("Crédito - " + numero);
            } else {
                String saldoStr = JOptionPane.showInputDialog("Saldo disponível:");
                double saldo = Double.parseDouble(saldoStr);
                CartaoDebito cd = new CartaoDebito(numero, titular, saldo);
                carteira.adicionarCartao(cd);
                listaModel.addElement("Débito - " + numero);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarteiraGUI::new);
    }
}
