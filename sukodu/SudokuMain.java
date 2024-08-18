package sukodu;
import java.awt.*;
import javax.swing.*;
/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L; 
   private static final String GameName = "SukoDu"; 
   private JComboBox<String> difficultyComboBox;
   private Board board = new Board();
   private JButton btnNewGame = new JButton("New Game");

   public SudokuMain() {
      initUI();
      pack();     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setTitle(GameName);
      setVisible(true);
   }

   private void initUI() {
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());

      JOptionPane.showMessageDialog(null, "Welcome to SukoDu! \n\n" 
      + "The objective is to fill a 9x9 grid with digits so that each column, each row," 
      + " and each of the nine 3x3 subgrids that compose the grid contain all of the digits from 1 to 9.\n\n" 
      + "Click on New Game to start playing!", "Welcome to SukoDu!", JOptionPane.INFORMATION_MESSAGE);

      JPanel topPanel = new JPanel();
      difficultyComboBox = new JComboBox<>(new String[]{"easy", "medium", "hard"});
      topPanel.add(new JLabel("Select Difficulty:"));
      topPanel.add(difficultyComboBox);
      cp.add(topPanel, BorderLayout.NORTH);
      cp.add(board, BorderLayout.CENTER);

      JPanel bottomPanel = new JPanel();
      bottomPanel.add(btnNewGame);
      cp.add(bottomPanel, BorderLayout.SOUTH);

      btnNewGame.addActionListener(e -> board.newGame(difficultyComboBox.getSelectedItem().toString()));
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new SudokuMain());
   }
}
