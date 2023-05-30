package EmployeeSystems;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class AttendanecSystemFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField employeeField;
    private JTextField employeeIDField;
    private JTextField departmentField;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AttendanecSystemFrame frame = new AttendanecSystemFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AttendanecSystemFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1141, 628);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel upPanel = new JPanel();
        upPanel.setBackground(new Color(6, 139, 49));
        upPanel.setBounds(0, 0, 1125, 47);
        contentPane.add(upPanel);
        upPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Attendance Monitoring System");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
        lblNewLabel.setBounds(207, 0, 750, 47);
        upPanel.add(lblNewLabel);

        JPanel midPanel = new JPanel();
        midPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        midPanel.setBounds(0, 47, 1125, 411);
        contentPane.add(midPanel);
        midPanel.setLayout(null);

        tableModel = new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Employee Name", "Employee ID", "Check - In", "Department", "Work File", "Break In", "Break Out", "Total Work Of Hours"
            }
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1125, 411);
        midPanel.add(scrollPane);

        JPanel downPanel = new JPanel();
        downPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        downPanel.setBounds(0, 457, 1125, 132);
        contentPane.add(downPanel);
        downPanel.setLayout(null);

        employeeField = new JTextField();
        employeeField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        employeeField.setText("Enter Employee Name");
        employeeField.setBounds(135, 11, 303, 50);
        employeeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (employeeField.getText().equals("")) {
					employeeField.setForeground(new Color(96, 96, 96));
					employeeField.setText("Enter Employee Name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (employeeField.getText().equals("Enter Employee Name")) {
					employeeField.setForeground(Color.BLACK);
					employeeField.setText("");
				}
			}
		});
        downPanel.add(employeeField);
 
        employeeIDField = new JTextField();
        employeeIDField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        employeeIDField.setText("Enter Employee ID");
        employeeIDField.setColumns(10);
        employeeIDField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (employeeIDField.getText().equals("Enter Employee ID")) {
					employeeIDField.setForeground(new Color(96, 96, 96));
					employeeIDField.setText("Enter Event Place");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (employeeIDField.getText().equals("Enter Employee ID")) {
					employeeIDField.setForeground(Color.BLACK);
					employeeIDField.setText("");
				}
			}
		});
        employeeIDField.setBounds(817, 11, 139, 50);
        downPanel.add(employeeIDField);

        departmentField = new JTextField();
        departmentField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        departmentField.setText("Enter Department Field");
        departmentField.setColumns(10);
        departmentField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (departmentField.getText().equals("")) {
					departmentField.setForeground(new Color(96, 96, 96));
					departmentField.setText("Enter Department Field");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (departmentField.getText().equals("Enter Department Field")) {
					departmentField.setForeground(Color.BLACK);
					departmentField.setText("");
				}
			}
		});
        departmentField.setBounds(489, 13, 303, 48);
        downPanel.add(departmentField);
        
        JPanel checkinPanel = new JPanel();
        checkinPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        checkinPanel.addMouseListener(new PanelButtonMouseAdapter(checkinPanel));
        checkinPanel.setBounds(135, 72, 129, 35);
        downPanel.add(checkinPanel);
        checkinPanel.setLayout(null);
        
        JLabel lblCheckIn = new JLabel("Check - In");
        lblCheckIn.setFont(new Font("Arial", Font.BOLD, 16));
        lblCheckIn.setBounds(29, 0, 100, 35);
        checkinPanel.add(lblCheckIn);
        
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        checkoutPanel.addMouseListener(new PanelButtonMouseAdapter2(checkoutPanel));
        checkoutPanel.setLayout(null);
        checkoutPanel.setBounds(309, 72, 129, 35);
        downPanel.add(checkoutPanel);
        
        JLabel lblCheckOut = new JLabel("Check - Out");
        lblCheckOut.setFont(new Font("Arial", Font.BOLD, 16));
        lblCheckOut.setBounds(10, 0, 119, 35);
        checkoutPanel.add(lblCheckOut);
        
        JPanel breakInPanel = new JPanel();
        breakInPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        breakInPanel.addMouseListener(new PanelButtonMouseAdapter3(breakInPanel));
        breakInPanel.setLayout(null);
        breakInPanel.setBounds(489, 72, 129, 35);
        downPanel.add(breakInPanel);
        
        JLabel lblBreakIn = new JLabel("Break - In");
        lblBreakIn.setFont(new Font("Arial", Font.BOLD, 16));
        lblBreakIn.setBounds(29, 0, 100, 35);
        breakInPanel.add(lblBreakIn);
        
        JPanel breakoutpanel = new JPanel();
        breakoutpanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        breakoutpanel.addMouseListener(new PanelButtonMouseAdapter4(breakoutpanel));
        breakoutpanel.setLayout(null);
        breakoutpanel.setBounds(663, 72, 129, 35);
        downPanel.add(breakoutpanel);
        
        JLabel lblBreakOut = new JLabel("Break - Out");
        lblBreakOut.setFont(new Font("Arial", Font.BOLD, 16));
        lblBreakOut.setBounds(20, 0, 109, 35);
        breakoutpanel.add(lblBreakOut);
        
        JPanel worksheerPanel = new JPanel();
        worksheerPanel.setBorder(new LineBorder(new Color(6, 139, 49), 2));
        worksheerPanel.addMouseListener(new PanelButtonMouseAdapter5(worksheerPanel));
        worksheerPanel.setLayout(null);
        worksheerPanel.setBounds(817, 72, 139, 35);
        downPanel.add(worksheerPanel);
        
        JLabel lblWorkSheet = new JLabel("Work Sheet");
        lblWorkSheet.setFont(new Font("Arial", Font.BOLD, 16));
        lblWorkSheet.setBounds(20, 0, 141, 35);
        worksheerPanel.add(lblWorkSheet);
    }




    // Helper method to get the current time in HH:mm format
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        return sdf.format(now);
    }

 /// Helper method to update the table data and save to a database (text file)
    private void updateAndSaveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\DatabaseAttendance.txt"))) {
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();
            StringBuilder sb = new StringBuilder();

            // Write the table headers
            for (int i = 0; i < columnCount; i++) {
                sb.append(tableModel.getColumnName(i));
                if (i < columnCount - 1) {
                    sb.append("\t");
                }
            }
            sb.append(System.lineSeparator());

            // Write the table data
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    Object value = tableModel.getValueAt(i, j);
                    sb.append(value);
                    if (j < columnCount - 1) {
                        sb.append("\t");
                    }
                }
                sb.append(System.lineSeparator());
            }

            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Check - in Panel Effect and Function
    private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
	         String employeeName = employeeField.getText();
	         String employeeID = employeeIDField.getText();
	         String department = departmentField.getText();
	                String checkInTime = getCurrentTime();

	           Employee employee = new Employee(employeeName, employeeID);
	           employee.setDepartment(department);
	          employee.setCheckInTime(checkInTime);

	           Object[] rowData = {
	                    employee.getName(),
	                    employee.getID(),
	                    employee.getCheckInTime(),
	                    employee.getDepartment(),
	                    null,
	                    null,
	                    null,
	                    null
	                };

	                tableModel.addRow(rowData);
	            
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}
		
		
		
	}

  
    
    private class PanelButtonMouseAdapter2 extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter2(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
			// check - out function
			
			 int selectedRow = table.getSelectedRow();
             if (selectedRow != -1) {
                 String hours = JOptionPane.showInputDialog(null, "How long was your duty?");
                 if (hours != null && !hours.isEmpty()) {
                     hours += "        \n"; // Add spacing after the hour value
                     table.setValueAt(hours, selectedRow, 7); // Assuming the total hours column index is 7
                     updateAndSaveToFile();
                     JOptionPane.showMessageDialog(null, "Attendance saved successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}
	}

    
    // Break - in panel effect and Function
	private class PanelButtonMouseAdapter3 extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter3(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			// break in function
			 int selectedRow = table.getSelectedRow();
             if (selectedRow != -1) {
                 String breakInTime = getCurrentTime();
                 table.setValueAt(breakInTime, selectedRow, 5);
             }
         
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}
	}

	
	// break out panel effects and function
	private class PanelButtonMouseAdapter4 extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter4(JPanel panel) {
			this.panel = panel;
		}
		public void mouseEntered(MouseEvent e){
			
			panel.setBackground(new Color(6, 137, 49));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		
		@Override
		public void mousePressed(MouseEvent e){
			panel.setBackground(new Color(6, 137, 49));
			
			// function 
			 int selectedRow = table.getSelectedRow();
             if (selectedRow != -1) {
                 String breakOutTime = getCurrentTime();
                 table.setValueAt(breakOutTime, selectedRow, 6);
             }
         
		} 
		
		@Override
		public void mouseReleased(MouseEvent e){
			panel.setBackground(new Color(240,  240, 240));
		}
	}
	
	
	// Insert Work Sheet Panel Effect and Functions 
	private class PanelButtonMouseAdapter5 extends MouseAdapter{
			
			JPanel panel;
			public PanelButtonMouseAdapter5(JPanel panel) {
				this.panel = panel;
			}
			public void mouseEntered(MouseEvent e){
				
				panel.setBackground(new Color(6, 137, 49));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(240, 240, 240));
			}
			
			@Override
			public void mousePressed(MouseEvent e){
				panel.setBackground(new Color(6, 137, 49));
				
				JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    table.setValueAt(fileName, table.getSelectedRow(), 4); // Assuming the work file column index is 4

                    // Save the file name in a text file
                    try {
                        FileWriter writer = new FileWriter("C:\\\\DatabaseAttendance.txt", true);
                        writer.write(fileName + System.lineSeparator());
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
				
				
			} 
			
			@Override
			public void mouseReleased(MouseEvent e){
				panel.setBackground(new Color(240,  240, 240));
			}
		}


}





