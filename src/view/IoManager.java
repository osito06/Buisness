package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class IoManager {
	private Scanner input;
	
	public IoManager(){
		input=new Scanner(System.in);
	}
    
	public void showGraphicMessage(String message){
		JOptionPane.showMessageDialog(null, message);

	}

	public short readGraphicShort (String message){
		return Short.parseShort(JOptionPane.showInputDialog(message));
	}

	public int readGraphicInt (String message){
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}

	public Double readGraphicDouble (String message){
		return Double.parseDouble(JOptionPane.showInputDialog(message));
	}

	public String readGraphicString (String message){
		
		return JOptionPane.showInputDialog(message);
	}

	public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

	public short readMenu(){
        String menuText = "1. Create Employe\n"
                + "2. Modificar empleado\n"
                + "3. Borrar empleaado\n"
                + "4. mostrar un empleado\n"
				+ "5. mostrar todos los empleados \n"
				+ "6. mostrar datos de la empresa\n"
				+ "7. Exit\n";
        return readGraphicShort(menuText);
    }

public void showErrorMessage(String message, String title){
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}