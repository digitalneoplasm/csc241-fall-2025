/*
Sample Key:
    <key id="d0" for="node" attr.name="color" attr.type="string">
        <default>yellow</default>
    </key>
 */

package xml;

public class Key {
    private String id;
    private String nodeOrEdge;
    private String name;
    private String dataType;

    private String defaultValue;

    public Key(String id, String nodeOrEdge, String name, String dataType) {
        this.id = id;
        this.nodeOrEdge = nodeOrEdge;
        this.name = name;
        this.dataType = dataType;
    }

    /**
     * If the key has a default value, returns true, else false.
     * @return Whether the key has a default value.
     */
    public boolean hasDefault() {
        return defaultValue != null;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
