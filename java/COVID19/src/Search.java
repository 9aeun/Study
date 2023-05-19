import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class start extends JFrame implements ActionListener{
	JButton button;
	TextField search;
	TextField result;
	
	start(){
		this.setTitle("도시별 코로나 사망자 검색");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("Search");
		search = new TextField(20);
		result = new TextField(30);
		
		Panel panel = new Panel();
		
		panel.setLayout(null);
		panel.add(button);
		
		button.setBounds(400, 100, 100, 50);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addActionListener(this);
		
		search.setBounds(100,100,300,100);
		panel.add(search);
		
		result.setBounds(100,200,300,300);
		panel.add(result);
		
		this.add(panel);
		this.setSize(900,600);
		this.setVisible(true);
		
	}
	
	// tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();  //getChildNodes()메소드는 자식 노드들을 NodeList타입으로 반환한다.
        Node nValue = (Node) nlList.item(0);
        if(nValue == null) 
            return null;
        return nValue.getNodeValue();
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==button) {
    		String get_text=search.getText();
    		String set_text="";
    		try {
    			while(true) {
    				String url="http://http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=iifF6nWLmR%2BPgzn%2BZKQfpfbSa%2FxrnJe8cRoVMGBOYvaLg0iv2dluN%2BamznkrvFKRPIQHCZkfU4shudRWucbZag%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200410&endCreateDt=20200410";
    				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    				Document doc = dBuilder.parse(url);
    				doc.getDocumentElement().normalize();
    				
    				NodeList nList = doc.getElementsByTagName("item");
    				
    				for(int temp = 0; temp < nList.getLength(); temp++){
    	                   Node nNode = nList.item(temp);
    	                   if(nNode.getNodeType() == Node.ELEMENT_NODE){ //Node 인터페이스의 getNodeType() 메서드노드 종류를 판정할 수 있다.
    	                      Element eElement = (Element) nNode;
    	                      if(temp==0) {
    	                          result.setText("시도별 코로나 사망자 수\n");  
    	                          result.setText(result.getText()+ "------------------------------------------\n");  
    	                      }
    	                      if(getTagValue("gubun",eElement).indexOf(get_text)>-1) {
    	                    	  System.out.println(getTagValue("deathCnt", eElement)+"\n");
    	                    	  result.setText(result.getText()+"도시: " + getTagValue("gubun",eElement)+"\n");
    	                    	  result.setText(result.getText()+"사망자 수: " +getTagValue("deathCnt", eElement)+"\n");
    	                    	  
    	                      }
    	                      
    	                      
    	                   }   // if end
    	                }   // for end
    			}
    		}catch (Exception error){   
	             error.printStackTrace();//에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
	          }   // try~catch end
    		result.setText(set_text);
    	}
    }
}

public class Search {
    public static void main(String[] args) {
        new start();
   } 
}
