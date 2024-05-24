<!DOCTYPE html>

<html lang="pt-BR" class="pf-m-redhat-font" >

    <head>
        <title>${msg("tituloLogin")}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="${url.resourcesPath}/images/seconci.jpg">
        <#if properties.styles?has_content>
            <#list properties.styles?split(' ') as style>
                <link href="${url.resourcesPath}/${style}" rel="stylesheet" />
            </#list>
        </#if>
    </head>

    <body>
        <div class="pf-c-login">
            <div class="pf-c-login__container">
                <header class="pf-c-login__header">
                    <img class="pf-c-brand" src="${url.resourcesPath}/images/seconci.jpg" alt="Seconci" />
                </header>

                <main class="pf-c-login__main">
                    <header class="pf-c-login__main-header">
                        <h1 class="pf-c-title pf-m-3xl">${msg("tituloConfiguracaoAutenticacaoDuasEtapas")}</h1>
                    </header>

                    <div class="pf-c-login__main-body">
                        <form class="pf-c-form" action="${url.loginAction}" method="post">
                            <#if message?has_content>
                                <#if message.type == 'error'>
                                    <p class="pf-c-form__helper-text pf-m-error">
                                        <span class="pf-c-form__helper-text-icon">
                                            <i class="fas fa-exclamation-circle" aria-hidden="false"></i>
                                        </span>
                                        ${msg("codigoInvalido")}
                                    </p>
                                </#if>
                            </#if>

                            <div class="pf-c-form__group">
                                <p>${msg("infoOTP")}</p>
                                <p>${msg("instalarAplicativo")}</p>
                            </div>

                            <div class="pf-c-form__group">
                                <ul id="dispositivosSuportados">
                                    <#list totp.supportedApplications as app>
                                        <li>${msg(app)}</li>
                                    </#list>
                                </ul>
                            </div>

                            <div class="pf-c-form__group">
                                <img id="kc-totp-secret-qr-code" src="data:image/png;base64, ${totp.totpSecretQrCode}" alt="Figure: Barcode"><br/>
                                <p><a href="${totp.manualUrl}" id="mode-manual">${msg("naoFoiPossivelLerCodigoQR")}</a></p>
                            </div>

                            <div class="pf-c-form__group">
                                <p>${msg("digitarCodigoUnico")}</p>
                                <p>${msg("fornecerNomeDispositivo")}</p>
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password">
                                    <span class="pf-c-form__label-text">
                                        ${msg("codigoAutenticador")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                <input
                                        class="pf-c-form-control"
                                        input="true"
                                        type="text"
                                        id="totp"
                                        name="totp"
                                        autocomplete="off"
                                        required />

                                <input type="hidden" id="totpSecret" name="totpSecret" value="${totp.totpSecret}" />
                                <#if mode??><input type="hidden" id="mode" name="mode" value="${mode}"/></#if>
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password">
                                    <span class="pf-c-form__label-text">
                                        ${msg("nomeDispositivo")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                <input
                                        class="pf-c-form-control"
                                        input="true"
                                        type="text"
                                        id="userLabel"
                                        name="userLabel"
                                        autocomplete="off"
                                        required />
                            </div>

                            <div class="pf-c-form__group">
                                <div class="pf-c-check">
                                    <input
                                            class="pf-c-check__input"
                                            type="checkbox"
                                            id="logout-sessions"
                                            name="logout-sessions"
                                            value="on"
                                            checked/>

                                    <label class="pf-c-check__label" for="logout-sessions">
                                        ${msg("deslogarSessoes")}
                                    </label>
                                </div>
                            </div>

                            <div class="pf-c-form__group pf-m-action">
                                <button class="pf-c-button pf-m-primary pf-m-block" type="submit">
                                    ${msg("ok")}
                                </button>
                            </div>
                        </form>
                    </div>
                </main>
            </div>
        </div>
    </body>

</html>
