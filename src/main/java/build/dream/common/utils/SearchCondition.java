package build.dream.common.utils;

public class SearchCondition {
    private String columnName;
    private String operationSymbol;
    private Object searchParameter;

    public SearchCondition() {

    }

    public SearchCondition(String columnName, String operationSymbol, Object searchParameter) {
        this.columnName = columnName;
        this.operationSymbol = operationSymbol;
        this.searchParameter = searchParameter;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public void setOperationSymbol(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public Object getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(Object searchParameter) {
        this.searchParameter = searchParameter;
    }
}
