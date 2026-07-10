(ns marketentry.facts "Switzerland market-entry catalog.")
(def catalog
  {"CHE" {:name "Switzerland"
          :owner-authority "BKB / simap.ch"
          :legal-basis "Federal Act on Public Procurement (BöB/PPA)"
          :national-spec "simap.ch supplier registration + UID"
          :provenance "https://www.simap.ch/"
          :required-evidence ["UID record"
                              "simap registration record"
                              "Commercial register extract"
                              "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / BKB"
          :rep-legal-basis "Swiss commercial registration (UID) typically required for federal procedures"
          :rep-provenance "https://www.simap.ch/"
          :corporate-number-owner-authority "Federal Statistical Office / commercial registers"
          :corporate-number-legal-basis "UID (Unternehmens-Identifikationsnummer)"
          :corporate-number-provenance "https://www.uid.admin.ch/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR"
          :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "DEU" {:name "Germany" :owner-authority "e-Vergabe" :legal-basis "GWB/VgV"
          :national-spec "e-Vergabe" :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract" "e-Vergabe registration record" "USt-IdNr record" "Authorized-representative record"]}
   "FRA" {:name "France" :owner-authority "PLACE" :legal-basis "Code de la commande publique"
          :national-spec "PLACE" :provenance "https://www.marches-publics.gouv.fr/"
          :required-evidence ["SIRET record" "PLACE registration" "RCS extract" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
