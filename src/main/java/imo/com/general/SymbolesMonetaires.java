/**
 * 
 */
package imo.com.general;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mbalde
 *
 */
public abstract class SymbolesMonetaires {

	private static Map<String, String> symbolesMonnaies = new HashMap<>();
	
	public static void initMonnaiePays() {
		symbolesMonnaies.put("Guinee", "GNF");
		symbolesMonnaies.put("France", "Euro");
		symbolesMonnaies.put("Senegal", "FCA");
	}
	
	public static String getSymboleMonetaires(String pays) {
		return symbolesMonnaies.get(pays);
	}
}
