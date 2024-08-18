package sukodu;
import java.awt.*;
import javax.swing.*;
/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning
   private JComboBox<String> difficultyComboBox;
   Board board = new Board();
   JButton btnNewGame = new JButton("New Game");

   // Constructor
   public SudokuMain() {
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());

      // Add difficulty selection pane
      JPanel topPanel = new JPanel();
      difficultyComboBox = new JComboBox<>(new String[]{"easy", "medium", "hard"});
      topPanel.add(new JLabel("Select Difficulty:"));
      topPanel.add(difficultyComboBox);
      cp.add(topPanel, BorderLayout.NORTH);
      cp.add(board, BorderLayout.CENTER);

      // Add a button to the south to re-start the game via board.newGame() with selected difficulty
      JPanel bottomPanel = new JPanel();
      bottomPanel.add(btnNewGame);
      cp.add(bottomPanel, BorderLayout.SOUTH);

      pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("SuKoDu");
      setVisible(true);

      // Add trigger to initialize the game
      btnNewGame.addActionListener(e -> board.newGame(difficultyComboBox.getSelectedItem().toString()));
   }

   // main method
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new SudokuMain();
         }
      });
   }
}
