package practice.email.parser

import org.jetbrains.spek.api.Spek
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class QuotesHeaderSuggestionsRegExSpecs : Spek() {
    init {
        given("string of text") {
            val s = "@lorem  ipsum dolor sit amet, 04/04/05, consectetuer 01:01:33 adipiscing elit. Aenean : "
            on("checking regexes") {
                it("should match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
                    }
                }
                it("should not match EMAIL regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.EMAIL.regex)
                    }
                }
                it("should match TIME regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = "Lorem:  ipsum dolor sit amet, 1.2.1999 consectetuer @ adipiscing elit. Aenean "
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = "13. 2015, Lorem  ipsum dolor sit amet, consec@tetuer adipiscing elit. Aenean 12:34"
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = "On 8 December 2014 at 15:16, superman <xxx@xxx.com> wrote:"
            on("checking regexes") {
                it("should  match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = """On Monday, September 15, 2014 6:50 AM, "yyyy@yyy.com" <yyyy@yyy.com> wrote:"""
            on("checking regexes") {
                it("should  match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = """> On 05 Nov smth 2014, at 00:30:33, yyyy@yyy.com wrote:"""
            on("checking regexes") {
                it("should  match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = """On Monday, September 2014, 15,  6:50 AM, "yyyy@yyy.com" <yyyy@yyy.com> wrote:"""
            on("checking regexes") {
                it("should  match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = """> On 2014 Nov smth 05, at 00:30:33, yyyy@yyy.com wrote:"""
            on("checking regexes") {
                it("should  match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should not match DATE regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = "> Date: 17 Jul 2015 13:25:18 GMT+3"
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match DATE regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
                    }
                }
                it("should match TIME regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.TIME.regex)
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
            val s = "12:34,\t\t\t\t lorem ipsum dolor sit amet - 3100 consectetuer adipiscing \t\t\t\tpav9147@yandex.ru\t\t\t\t"
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should not match DATE regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.DATE.regex)
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
            val s = """From: "papa pa" <eeee@eee.com> """
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match MIDDLE_COLON regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = """From : "papa pa" <eeee@eee.com> """
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match MIDDLE_COLON regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = """From "papa pa" <eeee@eee.com>: """
            on("checking regexes") {
                it("should match COLON regex") {
                    assertTrue { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should not match MIDDLE_COLON regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = """:From "papa pa" <eeee@eee.com>"""
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should not match MIDDLE_COLON regex") {
                    assertFalse {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = """Aan: Nfg FG FGfgf <xxx@xx.com>"""
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match MIDDLE_COLON regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
        given("string of text") {
            val s = """Onderwerp: [XXX YYY] Re: xxx ccc vvv bbb"""
            on("checking regexes") {
                it("should not match COLON regex") {
                    assertFalse { s.matches(QuotesHeaderSuggestionsRegEx.COLON.regex) }
                }
                it("should match MIDDLE_COLON regex") {
                    assertTrue {
                        s.matches(QuotesHeaderSuggestionsRegEx.MIDDLE_COLON.regex)
                    }
                }
            }
        }
    }
}
