package no.conduct.poc.wikimedia.domain;

public class WikimediaCacheEntry {

    private final String url;
    private final String description;

    protected WikimediaCacheEntry(Search result) {
        url = resolveUrl(result);
        description = resolveDescription(result);
    }

    private String resolveUrl(Search search) {
        return search.getConcepturi();
    }

    private String resolveDescription(Search search) {

        StringBuilder resolved = new StringBuilder();

        if (search.getLabel() != null) {
            resolved.append(search.getLabel());
        }
        if (search.getDescription() != null) {
            if (resolved.length() > 0) {
                resolved.append(", ");
            }
            resolved.append(search.getDescription());
        }
        if (resolved.length() == 0 && search.getMatch() != null) {
            resolved.append(search.getMatch().getText());
        }

        return resolved.toString();

    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

}
