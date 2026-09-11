(ns culture.facts
  "Country-level regional-culture catalog for Switzerland (CHE) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"CHE"
   [{:culture/id "che.dish.fondue"
     :culture/name "Fondue"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Swiss dish of melted cheese and wine served in a communal pot; promoted as a Swiss national dish by the Swiss Cheese Union in the 1930s and now a symbol of Swiss unity."
     :culture/url "https://en.wikipedia.org/wiki/Fondue"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.dish.roesti"
     :culture/name "Rösti"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Swiss dish of sautéed or shallow-fried potatoes, originally a farmers' breakfast in the Canton of Bern; many Swiss people consider rösti a national dish."
     :culture/url "https://en.wikipedia.org/wiki/Rösti"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.dish.raclette"
     :culture/name "Raclette"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Dish of Swiss origin based on heating cheese and scraping off the melted part, historically from the canton of Valais, described as one of Switzerland's national dishes alongside fondue and rösti."
     :culture/url "https://en.wikipedia.org/wiki/Raclette"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.dish.muesli"
     :culture/name "Muesli"
     :culture/name-local "Birchermüesli"
     :culture/country "CHE"
     :culture/kind :dish
     :culture/summary "Cold breakfast dish of rolled oats, fruit and nuts, developed around 1900 by Swiss physician Maximilian Bircher-Benner for patients in his hospital in Switzerland."
     :culture/url "https://en.wikipedia.org/wiki/Muesli"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.product.gruyere"
     :culture/name "Gruyère"
     :culture/country "CHE"
     :culture/kind :product
     :culture/summary "Hard Swiss cheese named after the town of Gruyères in the Canton of Fribourg, holding AOC/AOP protected designation (AOP since 2013); the most popular Swiss cheese in Switzerland and most of Europe."
     :culture/url "https://en.wikipedia.org/wiki/Gruyère_cheese"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.product.swiss-chocolate"
     :culture/name "Swiss chocolate"
     :culture/country "CHE"
     :culture/kind :product
     :culture/summary "Chocolate produced in Switzerland, internationally renowned for its quality; Swiss pioneers Daniel Peter (milk chocolate, 1875) and Rodolphe Lindt (conching, 1879) shaped modern chocolate-making."
     :culture/url "https://en.wikipedia.org/wiki/Swiss_chocolate"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.beverage.absinthe"
     :culture/name "Absinthe"
     :culture/country "CHE"
     :culture/kind :beverage
     :culture/summary "Anise-flavoured wormwood spirit created in the canton of Neuchâtel, Switzerland, in the late 18th century; the Val-de-Travers village of Môtiers is a focal point of its production."
     :culture/url "https://en.wikipedia.org/wiki/Absinthe"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.beverage.rivella"
     :culture/name "Rivella"
     :culture/country "CHE"
     :culture/kind :beverage
     :culture/summary "Swiss soft drink made from milk whey, created by Robert Barth in 1952 and seen as Switzerland's national beverage."
     :culture/url "https://en.wikipedia.org/wiki/Rivella"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.festival.carnival-of-basel"
     :culture/name "Carnival of Basel"
     :culture/name-local "Basler Fasnacht"
     :culture/country "CHE"
     :culture/kind :festival
     :culture/summary "The biggest carnival in Switzerland, held annually in Basel for exactly 72 hours; included in UNESCO's intangible cultural heritage since 2017."
     :culture/url "https://en.wikipedia.org/wiki/Carnival_of_Basel"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "che.heritage.old-city-of-bern"
     :culture/name "Old City of Bern"
     :culture/name-local "Altstadt"
     :culture/country "CHE"
     :culture/kind :heritage
     :culture/summary "Medieval city centre of Bern, a UNESCO Cultural World Heritage Site since 1983 for its compact and generally intact medieval core."
     :culture/url "https://en.wikipedia.org/wiki/Old_City_(Bern)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-che culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "CHE"))
                 " CHE entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
