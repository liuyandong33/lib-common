package build.dream.common.utils;

public class ContentValue {
    private String columnName;
    private Object value;
    private int symbolType;

    public ContentValue() {

    }

    public ContentValue(String columnName, Object value, int symbolType) {
        this.columnName = columnName;
        this.value = value;
        this.symbolType = symbolType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * 符号类型
     * 1: #{value}
     * 2: ${value}
     * 3: '${value}'
     * @return
     */
    public int getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(int symbolType) {
        this.symbolType = symbolType;
    }
}
