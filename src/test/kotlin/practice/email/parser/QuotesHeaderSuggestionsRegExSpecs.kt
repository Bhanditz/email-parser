package practice.email.parser

import org.jetbrains.spek.api.Spek
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class QuotesHeaderSuggestionsRegExSpecs : Spek() {
    init {
        given("string of text") {
            val s = "@lorem  ipsum dolor sit amet, 04/04/05, consectetuer 01:01:33 adipiscing elit. Aenean : "
            on("checking regexes") {
                it("should match COLUMN regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLUMN.regex) }
                }
                it("should match DATE_YEAR regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE_YEAR.regex)
                    }
                }
                it("should not match EMAIL regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
                it("should not match TIME regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = "Lorem:  ipsum dolor sit amet, 1.2.1999 consectetuer @ adipiscing elit. Aenean "
            on("checking regexes") {
                it("should match COLUMN regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLUMN.regex) }
                }
                it("should match DATE_YEAR regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE_YEAR.regex)
                    }
                }
                it("should not match EMAIL regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = "2015, Lorem  ipsum dolor sit amet, consec@tetuer adipiscing elit. Aenean 12:34"
            on("checking regexes") {
                it("should not match COLUMN regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLUMN.regex) }
                }
                it("should match DATE_YEAR regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE_YEAR.regex)
                    }
                }
                it("should match TIME regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
                    }
                }
                it("should match EMAIL regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = "12:34, lorem ipsum dolor sit amet - 3100 consectetuer adipiscing eli@t.cc Aenean "
            on("checking regexes") {
                it("should not match COLUMN regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLUMN.regex) }
                }
                it("should not match DATE_YEAR regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE_YEAR.regex)
                    }
                }
                it("should match TIME regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
                    }
                }
                it("should match EMAIL regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = "12:34,\t\t\t\t lorem ipsum dolor sit amet - 3100 consectetuer adipiscing \t\t\t\tpav9147@yandex.ru\t\t\t\t"
            on("checking regexes") {
                it("should not match COLUMN regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLUMN.regex) }
                }
                it("should not match DATE_YEAR regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE_YEAR.regex)
                    }
                }
                it("should match TIME regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
                    }
                }
                it("should match EMAIL regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
            }
        }

    }
}