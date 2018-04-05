//import java.awt.*;
//import java.awt.event.*;
//import java.awt.geom.*;
//import javax.swing.*;
//
//class Main {
//    private static final int _frameWidth = 800;
//    private static final int _frameHeight = 600;
//
//    private static JFrame createFrame() {
//        JFrame frame = new JFrame("Rotatable square");
//        frame.setPreferredSize(new Dimension(_frameWidth, _frameHeight));
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//
//        return frame;
//    }
//
//    public static void main(String[] args) {
//        final double[] accelerationRate = {0.08};
//
//        JFrame programFrame = createFrame();
//        final JButton butPlus = new JButton("Plus");
//        final JButton butMinus = new JButton("Minus");
//
//        final JPanel buttonPanel = new JPanel();
//        final JPanel panel = new JPanel();
//
//        butMinus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                accelerationRate[0] -= 0.05;
//            }
//        });
//
//        butPlus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                accelerationRate[0] += 0.05;
//            }
//        });
//
//        programFrame.add(panel);
//        programFrame.add(buttonPanel);
//        buttonPanel.add(butMinus);
//        buttonPanel.add(butPlus);
//        programFrame.pack();
//        Timer tm= new Timer(100, new ActionListener(){
//            int i = 0;
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                Graphics2D gr = (Graphics2D)panel.getRootPane().getGraphics();
//                panel.update(gr);
//                GeneralPath path = new GeneralPath();
//                Polygon poly = new Polygon();
//                poly.addPoint(0, 0);
//                poly.addPoint(100, 0);
//                poly.addPoint(100, 100);
//                poly.addPoint(0, 100);
//                path.append(poly, true);
//                int x = 0, y = 0;
//                gr.translate(400, 300);
//                AffineTransform transforms = AffineTransform.getRotateInstance((i++)* accelerationRate[0], x, y);
//                gr.transform(transforms);
//                gr.draw(path);
//            }
//        });
//        tm.start();
//    }
//}