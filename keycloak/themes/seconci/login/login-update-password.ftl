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
                        <h1 class="pf-c-title pf-m-3xl">${msg("tituloAtualizarSenha")}</h1>
                    </header>

                    <div class="pf-c-login__main-body">
                        <form class="pf-c-form" action="${url.loginAction}" method="post">
                            <#if message?has_content>
                                <#if messagesPerField.existsError("password", "password-confirm")>
                                    <p class="pf-c-form__helper-text pf-m-error">
                                        <span class="pf-c-form__helper-text-icon">
                                            <i class="fas fa-exclamation-circle" aria-hidden="false"></i>
                                        </span>
                                        ${msg("trocaInvalida")}
                                    </p>
                                </#if>
                            </#if>

                            <input
                                    autocomplete="username"
                                    name="username"
                                    type="hidden"
                                    value="${username}" />

                            <input
                                    autocomplete="current-password"
                                    name="password"
                                    type="hidden" />

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="username">
                                    <span class="pf-c-form__label-text">
                                        ${msg("senhaNova")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>
                                    <input
                                            class="pf-c-form-control"
                                            input="true"
                                            autocomplete="password-new"
                                            type="password"
                                            id="password-new"
                                            name="password-new"
                                            autocomplete="password"
                                            required />
                            </div>

                            <div class="pf-c-form__group">
                                <label class="pf-c-form__label" for="password">
                                    <span class="pf-c-form__label-text">
                                        ${msg("confirmarSenha")}
                                    </span>
                                    &nbsp;
                                    <span class="pf-c-form__label-required" aria-hidden="true">
                                        &#42;
                                    </span>
                                </label>

                                    <input
                                            class="pf-c-form-control"
                                            input="true"
                                            autocomplete="password-confirm"
                                            type="password"
                                            id="password-confirm"
                                            name="password-confirm"
                                            autocomplete="password-confirm"
                                            required />
                            </div>

                            <#if isAppInitiatedAction??>
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
                                        ${msg("trocarSenha")}
                                    </button>
                                </div>

                                <div class="pf-c-form__group pf-m-action">
                                    <button class="pf-c-button pf-m-primary pf-m-block" name="cancel-aia" type="submit" value="true">
                                        ${msg("cancelar")}
                                    </button>
                                </div>
                            <#else>
                                <div class="pf-c-form__group pf-m-action">
                                    <button class="pf-c-button pf-m-primary pf-m-block" type="submit">
                                        ${msg("trocarSenha")}
                                    </button>
                                </div>
                            </#if>
                        </form>
                    </div>
                </main>
            </div>
        </div>
    </body>

</html>
