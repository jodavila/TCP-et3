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