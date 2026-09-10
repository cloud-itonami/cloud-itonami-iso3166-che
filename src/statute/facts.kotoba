(ns statute.facts
  "General-law compliance catalog for Switzerland (CHE) -- a 44th
  country-level entry (see cloud-itonami-iso3166-jpn/-usa/-gbr/-deu/-fra/
  -can/-aus/-kor/-nld/-ita/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/
  -chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/-tha/
  -are/-vnm/-idn/-phl/-egy/-tur/-nga/-sau/-mys/-aut for the first
  forty-three) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Reuses this tick-window's already-verified capital-status finding
  from cloud-itonami-municipality-che-bern (tick 128): Switzerland has
  NO de jure capital designation in its Federal Constitution; Bern
  serves as the de facto seat of federal government since 1848, a
  stable and well-understood constitutional arrangement.

  Switzerland's official federal legal-information system
  (fedlex.admin.ch) requires JavaScript and could not be rendered via
  WebFetch (the same class of issue as stadtrecht.bern.ch, tick 128),
  so this catalog's entries instead cite established
  international-body / professional legal-research mirrors.

  Federal Act on the Amendment of the Swiss Civil Code (Part Five:
  The Code of Obligations), SR 220 -- title and 30 March 1911
  adoption date directly confirmed via WIPO Lex (wipo.int, an
  established international-body legal database used elsewhere this
  session), which states verbatim: 'Federal Act of March 30, 1911, on
  the Amendment of the Swiss Civil Code (Part Five: The Code of
  Obligations)'. Entered into force 1 January 1912.

  Federal Act on Data Protection (FADP), SR 235.1 -- directly
  confirmed via DLA Piper's 'Data Protection Laws of the World'
  resource (a professional legal-research publication, the same
  source used successfully for Saudi Arabia's PDPL at tick 120),
  which states verbatim: 'The processing of personal data is mainly
  regulated by the Federal Act on Data Protection of 25 September
  2020 (FADP)... has entered into force on 1 September 2023.'

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"CHE"
   [{:statute/id "che.code-of-obligations-1911"
     :statute/title "Federal Act on the Amendment of the Swiss Civil Code (Part Five: The Code of Obligations)"
     :statute/jurisdiction "CHE"
     :statute/kind :law
     :statute/law-number "SR 220"
     :statute/url "https://www.wipo.int/wipolex/edocs/lexdocs/laws/en/ch/ch310en.html"
     :statute/url-provenance :wipo-lex-mirror
     :statute/enacted-date "1911-03-30"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "che.fadp-2020-federal-act-data-protection"
     :statute/title "Federal Act on Data Protection (FADP)"
     :statute/jurisdiction "CHE"
     :statute/kind :law
     :statute/law-number "SR 235.1"
     :statute/url "https://www.dlapiperdataprotection.com/?t=law&c=CH"
     :statute/url-provenance :dlapiper-data-protection-laws-of-the-world
     :statute/enacted-date "2020-09-25"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-che statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "CHE")) " Switzerland entries seeded "
                 "with wipo.int/dlapiperdataprotection.com citations. "
                 "Extend `statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
