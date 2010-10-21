# README
## 概要
* Google App Engine上で動く [Igo][igo] を利用した形態素解析サーバ
* それを利用して形態素解析を行うJavaScript関数セット

[igo]: http://igo.sourceforge.jp/

## 参照
* [1] <http://d.hatena.ne.jp/sile/20101006/1286374552>
* [2] <http://d.hatena.ne.jp/sile/20101018/1287409899>

## デプロイ方法
* 前提
  * GAEのSDKがインストールされている必要がある
  * Igoのバイナリ辞書が gae-app/war/ 直下に 'ipadic' という名前で配置されている必要がある
* デプロイ
 > $ cd gae-app/igo-morp/  
 > $ GAE_JAVA_SDK_HOME=${SDKのインストールディレクトリ} ant  # アプリケーションをビルドする
 > $ appcfg.sh update war  # a] 本番にデプロイする場合  
 > $ dev_appserver.sh war  # b] 開発環境で試す場合  

## Igoの辞書作成方法
* [Igoのドキュメント][igo] で説明されている方法で作成可能
* Igoのjarファイルには gae-app/igo-morp/war/WEB-INF/lib/igo-0.4.2-gae.jar にあるものを使用する
  * 何らかの理由で上記jarファイルが使えない場合は、ソースコードからjarをビルドする　
  * その際には以下の手順に従って、GAE用のパッチを当てる必要がある
    > $ tar zxvf igo-0.4.2-src.tar.gz    # ソース一式を解凍する  
    > $ patch -p0 < igo-0.4.2-gae.patch  # GAE用のパッチを当てる。詳しくは、参照[1]を参照。  
