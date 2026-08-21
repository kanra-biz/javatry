/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => error
        // result => mystic8null:mai
        // my take => 違う型同士の計算になるので、足し合わせることができず error になると推測した。
        // actually => 初めの演算でstringが出てきたので、数字ではなく文字列計算として扱われていた。
        // learnings => 異なる型で演算するときは、型変換できるものがもう一つの型に合わせて計算されるのかもしれない。
        //              null + 1 のように型変換で型を合わせられないものはコンパイルエラーになる。
        // done ishido [いいね] result, my take とカテゴリ化されていてわかりやすいです^^ by jflute (2026/07/29)
        // [ふぉろー] Javaの場合、Stringと別のクラスが+で連結された場合は、文字列に引きずられるようなイメージです。
        // そのとき、その別のクラスはtoString()が呼ばれて、その戻り値(String)と文字列連結されます。
        // toString()はObject型のメソッドで、すべてのクラスが継承しているので、どのクラスでも呼ぶことができます。
        // 一方で、"null" という文字列になっちゃうのは、プログラミング言語の決めで、言語によりけりです。
        // エラーになる言語もあれば、空文字になる言語もあれば、一つでもあればすべてnullという言語も。
        // "null" で出る仕様のメリデメ:
        // o デメリット: 画面やメールでnullって出てきやすい
        // o メリット: 開発時は画面にnullって出てきてわかりやすい
        //            (素通りにメリット: 多少変でも動いた方が良い場面もあるかも!?)
        // 些細なことでもメリデメ考える習慣が大事。
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // 1 (1丁目1番地)
        String land = "oneman"; // 2 (2丁目2番地)
        sea = land; // seaの1丁目1番地って書かれた紙を消しゴムで消して、2丁目2番地に書き換える
        land = land + "'s dreams"; // 3: 's dreams
        log(land); // 4: oneman's dreams
        log(sea); // your answer? => oneman
        // result => oneman
        // done jflute 1on1にて、変数とインスタンスについて話をする予定 (2026/07/29)
        // #1on1: インスタンスとは？ (2026/07/29)
        // $ クラスを使って、値をあてはめていって、決まった形で確保しておくもの
        // 一軒家の例。
        // インスタンスにフォーカスする大切さ。インスタンス間違いなど起こさないように。
        // 変数とは？
        // オブジェクト型は、ポインターみたいに、アドレス(参照)を持っているだけ。
        // 変数とインスタンスは、1:1ではなく、n:1になりうる
        // (後半エクササイズで、メソッド間でn:1になるケースの例)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
        // result => 415
        // #1on1: プリミティヴ型 (2026/07/29)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        sea = land.add(new BigDecimal(1));
        sea.add(new BigDecimal(1));
        log(sea); // your answer? => { BigDecimal: { 415, 1, 1 }}
        // result => 416
        // my take => クラスのようなものかと思い、seaにBigDecimalと紐づく形で415, 1, 1が格納されると推測した。
        // actually => BigDecimalはデータ型であり、.add()は足し合わせた結果を返すメソッドであった。
        //             そのため、81行目では415に1を足し合わせた結果をseaに格納し、82行目では1を足した結果を返すところがないため、結果として416が出力された。
        // learnings => .add()は足し合わせた結果を返すメソッドであり、BigDecimalは丸め誤差を生まないためのデータ型だと学んだ。
        // done ishido [いいね] add()の分析しっかりできています by jflute (2026/07/29)
        // #1on1: BigDecimalのソースコードリーディングしてみた (2026/07/29)
        // 構造に着目して、目的だけ知る。
        // インスタンス変数とインスタンスメソッドの話。
        // Pythonの例と比べてみた by いしどさん
        // done jflute 次回の1on1にて、immutableのお話 (2026/07/29)
        // #1on1: immutableとは？ (2026/08/13)
        // immutable=不変な, mutable=可変な
        // o immutableなクラス(インスタンス) // default!?
        // o immutableな変数
        // 
        // BigDecimalはimmutableなクラスとして設計されている。
        // そういうクラスをnewしたら、immutableなインスタンスができあがる。
        //
        // immutableなクラスや変数のメリット/デメリットは？
        // (メリット)
        // o $開発において定数として扱うものとかをimmutableにして安全にする by いしどさん
        // o 読み飛ばしとかの可読性につながる (immutableは情報である)
        //
        // (デメリット)
        // o $単純に書き換えられないので、mutableの場面が多く、使い分け/適材適所が？ by いしどさん
        //   → 適材適所ってデメリットもあって、使う側が使い分けの判断コストが掛かる面がある。
        //   → あまりに細かい適材適所はちょっと大変。
        //   → かといってなんでもできる一つの選択肢は、良いデザインとも言えない。
        //   → 制限が掛かってるからこそ安全で安心して使える → immutable
        //   → でも、あまりに細かい適材適所は... (無限ループ)
        // o メモリ使いすぎかも!?
        // o immutableって手間を掛けてimmutableにするものなので言語サポート欲しい
        //
        // immutableの歴史:
        // o 昔は、メモリが貧弱で、new/newしてたら足りない
        // o 昔は、言語/エディターが貧弱で、immutableも手間が掛かる
        // o 今や、メモリもたくさん、言語も発達、デメリットが薄くなってきた
        //
        // immutableのバランス:
        // o 言語や組織や個人の文化に寄る
        // o Java: 歴史的なこともあるし、コンセプトもあるし、8:2くらいでimmutableで無理しない
        //  → jflute個人も、Java書く時はそんな感覚
        //  → mutableなクラスを使う時、安全性と可読性を演出する手段は他にもあるのでそれで工夫する。
        // o 一方で、100%immutable推しの言語もある
    }

    // $ 相談: じっくりやったけど進捗が心配 by いしどさん
    // 現時点では、そこまで気にしなくてもOK。そして、遅いわけではない。

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null
        // result => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => null
        // result => 0
        // my take => `instanceDockside`には何も格納されておらず、何もないものを呼んでいるので`null`になると推測した。
        // actually => intはただの型でありオブジェクトを用意せず、何も定義されていないintは0になるので結果0と返された。
        // learnings => 大文字の名前で型定義とオブジェクトの用意を、小文字の略称で型定義のみを行うことを知り、使い分けられることを学んだ。
        // done ishido [ふぉろー] intはプリミティブ型で、Integerがオブジェクト型になります。 by jflute (2026/08/13)
        // 言葉の使い方ですが、どちらも型(定義)ではあって、型の種類が違うという感じですね。
        // プリミティブ型は「値そのもののみ」を定義する型、オブジェクト型は「構造体のようなもの」を定義する型。
        // Integerは、intをラップしてオブジェクトとして扱えるようにした型という感じです。
        // プリミティブ型をラップしているオブジェクトなので「ラッパー型」とも呼ばれます。

        // #1on1: プリミティブ、オブジェクトなどの言葉 (2026/08/13)
        // プリミティブ型: int, long, ... (先頭が小文字のもの)
        // オブジェクト型: String, Integer, Step01VariableTest, ... (プリミティブ型以外全部)
        // ラッパー型: Integer, Long, ... (プリミティブ対応のオブジェクト型8個のみ)
        // (StringもBigDecimalもラッピングしてるけど、ラッパー型ではない)
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null
        // result => null
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|magician
        // result => bigband|1|null|magician
    }

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor
        // result => harbor
        // learnings => 「なぜ、プライベート関数に参照値が渡されているはずなのに、なぜ値が変わらないのか？」198行目の問題を経てもう一度考えてみる。
        //              理由は2つ。
        //              - Stringはインスタンスの中身が不変でこと。
        //              - .concat()は不変なインスタンスの中身を参照し、それに()内を加えたものをreturnすること。
        //              この二つのことから、sea.concat(landStr);は "harbor416" を返しているだけでおり、元のインスタンスには影響していないため、 "harbor" が出力された。
        // done ishido [いいね] 不変なクラスなので、concat()も戻すスタイルで、しかも受け取ってないし... by jflute (2026/08/13)
        // 受け取ったとしても、helpメソッドのsea変数は別物なのでtestメソッド側には何も影響がないということですね。
        // #1on1: immutableがわかっていたら、helpメソッドを読まないでも答えがわかる (2026/08/13)
        // immutableは情報、読み手にとって、その情報を使って理解を進めることができる。
        // mutableの引数は、読み手にとって、絶対に確認をしないといけなくなる。
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => 415
        // result => harbor416
        // my take => `helpMethodArgumentMethodcall(StringBuilder sea, int land) ` 内で新たなseaインスタンスが作られており、それに `.append(land)` されているだけなので、呼び出し元のseaインスタンスには影響しないと考えた。
        // actually => `helpMethodArgumentMethodcall(StringBuilder sea, int land) ` 内で新たなseaインスタンスを作っているわけではなく、メソッド引数の中にインスタンスの参照値を格納している。
        //             なので、 `sea.append(land)` のseaはインスタンスの参照値であり、それを参照してappendしているので元のインスタンスがharborに416が加えられてharbor416となる。
        // learnings => プライベート関数の引数でインスタンスを受け入れるときは、インスタンスを複製し新たなインスタンスを作っているのではなく、入力インスタンスの参照値が入る。
        //              プライベート関数内で参照値自体に処理される、参照値内のインスタンスに処理されるのかを紐解く必要あり。
        //              では、179行目の問題はプライベート関数に参照値が渡されているはずなのに、なぜ値が変わらない？
        // #1on1: ↑一個前のエクササイズのこと。いまやimmutableが理解できたので問題なし。 (2026/08/13)
        // done ishido [いいね] "入力インスタンスの参照値が入る" 要はアドレスだけが伝達してるだけなので... by jflute (2026/08/13)
        // testメソッドのseaもhelpメソッドのseaも同じアドレスを持って同じインスタンスを参照することになります。
        // done jflute 1on1にて深掘り (2026/08/13)
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor
        // result => harbor
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }
    // TODO jflute 1on1ふぉろーここまでやった (2026/08/13)

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    private int piari;
    public void test_variable_writing() {
        // define variables here
        String sea = "mystic";
        Integer land = null;
        log(sea + "," + land + "," + piari);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 以下のlogの出力結果は？
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    private String MiraCosta;
    private int Celebration;
    private String DLand = "Angel";
    private StringBuilder TStory;
    public void test_variable_yourExercise() {
        // write your code here
        StringBuilder FantasySprings = new StringBuilder("Little");
        Celebration = 4;
        StringBuilder Dreamlights = new StringBuilder("Lost");
        PhilharMagic(Dreamlights, FantasySprings);
        MiraCosta = FantasySprings + DLand + TStory;
        MiraCosta.concat("s");
        log(MiraCosta + "s");
    }

    private void PhilharMagic(StringBuilder Ambassador, StringBuilder BonVoyage) {
        String FantasySprings = "Boy";
        Celebration++;
        TStory = new StringBuilder("Caroler");
        Celebration++;
        Ambassador.append(FantasySprings);
        BonVoyage = Ambassador.append(Celebration);
    }
}
