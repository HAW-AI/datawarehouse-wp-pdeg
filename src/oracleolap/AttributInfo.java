package oracleolap;

/**
 *
 * @author abb703
 */
public class AttributInfo {

    public AttributInfo(String anzeigeName, String tabelle, String spalte) {
        this.name = anzeigeName;
        this.tabelle = tabelle;
        this.spalte = spalte;
    }
    public final String name, tabelle, spalte;

    public String toField() {
        return String.format("\"%s\".\"%s\"", tabelle, spalte);
    }

    //TODO: Eine HashMap mit diesen Objekten vlt. in Main erstellen.
    @Override
    public String toString() {
        return name;
    }
}
