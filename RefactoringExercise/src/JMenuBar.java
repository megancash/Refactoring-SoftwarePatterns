/* Student Name: Megan Cash
 * Student Number: C19317723
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class JMenuBar extends JFrame implements ActionListener {

	private JMenuItem open, save, saveAs, create, modify, delete, firstItem, lastItem, nextItem, prevItem, searchById, searchBySurname, listAll, closeApp;

	//initialise menu bar
	private JMenuBar menuBar() {

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu, recordMenu, navigateMenu, closeMenu;
		String[] menuOptions = { "File", "Records", "Navigate", "Exit" };

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		recordMenu = new JMenu("Records");
		recordMenu.setMnemonic(KeyEvent.VK_R);
		navigateMenu = new JMenu("Navigate");
		navigateMenu.setMnemonic(KeyEvent.VK_N);
		closeMenu = new JMenu("Exit");
		closeMenu.setMnemonic(KeyEvent.VK_E);

		JMenu[] menu = { fileMenu, recordMenu, navigateMenu, closeMenu };
		addToMenuBar(menu, menuBar);

		JMenuItem[] menuItem = { open, save, saveAs, create, modify };
		int[] keyEvent = { KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_F2, KeyEvent.VK_N, KeyEvent.VK_E };
		String[] optionName = { "Open", "Save", "Save As", "Create new Record", "Modify Record" };

		setMenuOptions(fileMenu, open, "Open", KeyEvent.VK_O);
		setMenuOptions(fileMenu, save, "Save", KeyEvent.VK_S);
		setMenuOptions(fileMenu, saveAs, "Save As", KeyEvent.VK_F2);
		setMenuOptions(recordMenu, create, "Create new Record", KeyEvent.VK_N);
		setMenuOptions(recordMenu, modify, "Modify Record", KeyEvent.VK_E);

		recordMenu.add(delete = new JMenuItem("Delete Record")).addActionListener(this);
		navigateMenu(navigateMenu);
		closeMenu(closeMenu);

		return menuBar;
	}

	public void closeMenu(JMenu closeMenu) {

		closeMenu.add(closeApp = new JMenuItem("Close")).addActionListener(this);
		closeApp.setMnemonic(KeyEvent.VK_F4);
		closeApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));

	}

	public void navigateMenu(JMenu navigateMenu) {

		JMenuItem[] menuItem = { firstItem, prevItem, nextItem, lastItem };
		JMenuItem[] menuItemSearch = { searchById, searchBySurname, listAll };
		String[] optionName = { "First", "Previous", "Next", "Last" };
		String[] optionNameSearch = { "Search by ID", "Search by Surname", "List all Records" };

		for (int i = 0; i <= menuItem.length; i++) {
			navigateMenu.add(menuItem[i] = new JMenuItem(optionName[i])).addActionListener(this);
		}

		navigateMenu.addSeparator();

		for (int i = 0; i <= menuItemSearch.length; i++) {
			navigateMenu.add(menuItemSearch[i] = new JMenuItem(optionNameSearch[i])).addActionListener(this);
		}
	}

	public void setMenuOptions(JMenu menuOption, JMenuItem item, String menuOptionString, int keyEvent) {

		menuOption.add(item = new JMenuItem(menuOptionString)).addActionListener(this);
		item.setMnemonic(keyEvent);
		item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, ActionEvent.CTRL_MASK));
	}

	public void addToMenuBar(JMenu[] menu, JMenuBar menuBar) {
		for (int i = 0; i <= menu.length;) {
			menuBar.add(menu[i]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
